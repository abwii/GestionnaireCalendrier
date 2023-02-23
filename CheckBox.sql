#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: User
#------------------------------------------------------------

CREATE TABLE User(
        Id          Int  Auto_increment  NOT NULL ,
        Identifiant Varchar (25) NOT NULL ,
        Password    Varchar (30) NOT NULL
	,CONSTRAINT User_PK PRIMARY KEY (Id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Box
#------------------------------------------------------------

CREATE TABLE Box(
        boxid    Int  Auto_increment  NOT NULL ,
        boxzonea Bool NOT NULL ,
        boxzoneb Bool NOT NULL ,
        boxzonec Bool NOT NULL
	,CONSTRAINT Box_PK PRIMARY KEY (boxid)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: cocher
#------------------------------------------------------------

CREATE TABLE cocher(
        boxid Int NOT NULL ,
        Id    Int NOT NULL
	,CONSTRAINT cocher_PK PRIMARY KEY (boxid,Id)

	,CONSTRAINT cocher_Box_FK FOREIGN KEY (boxid) REFERENCES Box(boxid)
	,CONSTRAINT cocher_User0_FK FOREIGN KEY (Id) REFERENCES User(Id)
)ENGINE=InnoDB;

