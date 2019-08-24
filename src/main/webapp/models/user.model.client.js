function User(id, username, password, firstName, lastName, role) {
    this.id = id
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
    this.fields = {
        'id': this.id,
        'username': this.username,
        'password': this.password,
        'firstName': this.firstName,
        'lastName': this.lastName,
        'role': this.role
    }

    this.getId = getId;
    this.setId = setId;

    this.getUsername = getUsername;
    this.setUsername = setUsername;

    this.getPassword = getPassword;
    this.setPassword = setPassword;

    this.getFirstName = getFirstName;
    this.setFirstName = setFirstName;

    this.getLastName = getLastName;
    this.setLastName = setLastName;

    this.getRole = getRole;
    this.setRole = setRole;

    this.getJsonData = getJsonData;

    function setId(id) {
        this.id = id;
    }

    function getId() {
        return this.id;
    }

    function setUsername(username) {
        this.username = username;
    }

    function getUsername() {
        return this.username;
    }

    function setPassword(password) {
        this.password = password;
    }

    function getPassword() {
        return this.password;
    }

    function setFirstName(firstName) {
        this.firstName = firstName;
    }

    function getFirstName() {
        return this.firstName;
    }

    function setLastName(lastName) {
        this.lastName = lastName;
    }

    function getLastName() {
        return this.lastName;
    }

    function setRole(role) {
        this.role = role;
    }

    function getRole() {
        return this.role;
    }

    function getJsonData() {
        var user = {};
        for (var field in this.fields) {
            if (this.fields[field] != null) {
                user[field] = this.fields[field];
            }
        }

        return user;
    }

}