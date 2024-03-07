package com.tpsit.med_20_r_m

class User {
    var username = ""
    var mail = ""
    var password = ""
    var codicefiscale = ""
    var usertype = ""

    constructor(Username :String, Mail :String, Password :String, CodiceFiscale :String, Usertype :String){
        this.username = Username
        this.mail = Mail
        this.password = Password
        this.codicefiscale = CodiceFiscale
        this.usertype = Usertype
    }
}