function AdminUserServiceClient() {

    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.searchUsers = searchUser;
    this.url = 'https://cs5610-su19-java-server-cdesai.herokuapp.com/api/users';
    var self = this;


    // POST - Create User
    function createUser(user) {
        return fetch(self.url, {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function (response) {
            return response.json();
        })
    }

    // GET - Read Users
    function findAllUsers() {
        return fetch(self.url)
            .then(function (response) {
                return response.json();
            })
    }

    // GET -  Read Single User
    function findUserById(id) {
        return fetch(self.url + "/" + id).then(function (response) {
            return response.json();
        })
    }

    // PUT - Update User
    function updateUser(id, user) {
        return fetch(self.url + "/" + id, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function (response) {
            return response.json();
        })
    }

    // DELETE - Delete User
    function deleteUser(id) {
        return fetch(self.url + "/" + id, {
            method: 'DELETE'
        }).then(function (response) {
            return response.json();
        })
    }

    // Search User
    function searchUser(user) {
        return fetch(self.url + "/search", {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function (response) {
            return response.json();
        })
    }
}