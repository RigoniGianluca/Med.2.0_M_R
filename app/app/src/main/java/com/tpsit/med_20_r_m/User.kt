package com.tpsit.med_20_r_m

class User {
    var nome = ""
    var cognome = ""
    var username = ""
    var mail = ""
    var password = ""
    var codicefiscale = ""
    var usertype = ""

    constructor(Nome :String, Cognome: String, Username :String, Mail :String, Password :String, CodiceFiscale :String, Usertype :String){
        this.nome = Nome
        this.cognome = Cognome
        this.username = Username
        this.mail = Mail
        this.password = Password
        this.codicefiscale = CodiceFiscale
        this.usertype = Usertype
    }
}