(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $searchBtn, $updateBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var userService;
    jQuery(main);

    function main() {
        $usernameFld = $('#usernameFld');
        $passwordFld = $('#passwordFld');
        $firstNameFld = $('#firstNameFld');
        $lastNameFld = $('#lastNameFld');
        $roleFld = $('#roleFld');;
        $searchBtn = $('.wbdv-search');
        $createBtn = $('.wbdv-create');
        $updateBtn = $('.wbdv-update');
        $refreshBtn = $('.wbdv-refresh');
        $tbody = $('.wbdv-tbody');
        $userRowTemplate = $('.wbdv-template');
        userService = new AdminUserServiceClient()
        //button bindings
        $createBtn.click(createUser);
        $searchBtn.click(searchUsers);
        $updateBtn.click(updateUser);
        $refreshBtn.click(refreshUsers);

        userService
            .findAllUsers()
            .then(renderUsers).then(clearForm);
    }

    // Create User
    function createUser() {
        if ($roleFld.val() == '') {
            alert("Please select a ROLE!");
        } else {
            var user = new User(null, $usernameFld.val(), $passwordFld.val(), $firstNameFld.val(), $lastNameFld.val(), $roleFld.val());
            userService.createUser(user.getJsonData()).then(renderUsers).then(clearForm);
        }
    }

    // Find All Users
    function findAllUsers() {
        userService.findAllUsers().then(renderUsers).then(clearForm);
    }

    // Find User By Id
    function findUserById(id) {
        userService.findUserById(id).then(renderUser);
    }

    // Select a User
    function selectUser(event) {
        $selectBtn = $(event.currentTarget);
        var id = $selectBtn.parent().parent().parent().attr('id');
        findUserById(id);
    }

    // Update User
    function updateUser(event) {
        $updateBtn = $(event.currentTarget);
        var id = $('.wbdv-form').attr('id');
        if ($roleFld.val() == '') {
            alert("Please select a ROLE!");
        } else {
            var user = new User(id, $usernameFld.val(), $passwordFld.val(), $firstNameFld.val(), $lastNameFld.val(), $roleFld.val());
            userService.updateUser(id, user.getJsonData()).then(renderUsers).then(clearForm);
        }
    }

    // Delete User
    function deleteUser(event) {
        $removeBtn = $(event.currentTarget);
        var id = $removeBtn.parent().parent().parent().attr('id');
        userService.deleteUser(id).then(renderUsers).then(clearForm);
    }

    // Search User
    function searchUsers() {
        var user = new User(null, $usernameFld.val(), $passwordFld.val(), $firstNameFld.val(), $lastNameFld.val(), $roleFld.val());
        userService.searchUsers(user.getJsonData()).then(renderUsers);
        if ($roleFld.val() == '' && $usernameFld.val() == '' && $firstNameFld.val() == '' && $lastNameFld.val() == '' && $passwordFld.val() == '') {
        } else {
            $refreshBtn.show();
        }
    }

    // Refresh Users
    function refreshUsers() {
        $refreshBtn.hide();
        findAllUsers();
    }

    // Render User to Form
    function renderUser(user) {
        const userObject = createUserObject(user);
        $usernameFld.val(userObject.getUsername());
        $passwordFld.val(userObject.getPassword());
        $firstNameFld.val(userObject.getFirstName());
        $lastNameFld.val(userObject.getLastName());
        $roleFld.val(userObject.getRole());
        $('.wbdv-form').attr('id', userObject.getId());
    }

    // Render Users into rows
    function renderUsers(users) {
        $tbody.empty()
        for (var u in users) {
            const user = createUserObject(users[u])
            const $rowClone = $userRowTemplate.clone();
            $rowClone.removeClass('wbdv-hidden');
            $rowClone.find('.wbdv-username').html(user.getUsername());
            $rowClone.find('.wbdv-first-name').html(user.getFirstName());
            $rowClone.find('.wbdv-last-name').html(user.getLastName());
            $rowClone.find('.wbdv-role').html(user.getRole());
            $rowClone.attr('id', user.getId());
            $rowClone.find('.wbdv-edit').click(selectUser);
            $rowClone.find('.wbdv-remove').click(deleteUser);
            $tbody.append($rowClone);
        }
    }

    // Create User model object from JSON
    function createUserObject(jsonData) {
        var userObject = new User(jsonData.id, jsonData.username, jsonData.password, jsonData.firstName, jsonData.lastName, jsonData.role);
        return userObject;
    }

    // Clear Form
    function clearForm() {
        $('.form-control').val('');
        $('.wbdv-form').attr('id', '');
    }
})();