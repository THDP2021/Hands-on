package com.oop.exampleEncapsulation;

//Exercise 2: Encapsulation
//Once you practice your private attributes and public methods, you're ready for next steps.
//You need to remember that encapsulation is how you get the info.
//In this exercise you have 3 classes, Film, Series and RentalTime
//The objective is: create a class RentalTime for share their objects as an attribute in classes
//Series and Film.
//Your main method need to have 4 objects, 2 for Series and 2 for Film.
//Finally, you need to expose your objects to your user.
//(It doesn't need that user input this data.)
//HELP: You can develop your objects with this structure:
//ObjectFilm(name,id,ObjectRentalTime)

public class SecondExample {

    public static void main(String[] args){
        System.out.print("Hello there, this is the second exercise to promote the knowledge about " +
                "Object Oriented Programming: Encapsulation\n");
        System.out.print("Your work will be create 4 objects 2 for film and 2 for series.\n");

        //Remember to use an object RentalTime in all your objects.
        RentalTime r1=new RentalTime(12,"April",2021,6);
        //create 2 films using rentaltime object
        RentalTime r2= new RentalTime(2,"May",2019,12);
        //Create 2 series using rentaltime

        //Expose 2 of your objects with structured manner. (sout)



    }
}

////////////// RENTAL TIME CLASS ////////////////////////
//Here you have 4 attributes: day, month, year and returnTime. This last on months.
//All your attributes need to be private.

class RentalTime {
    Integer dayR;
    String month;
    Integer yearR;
    Integer howManyTime; //on months.

    //Create a constructor for private attributes.



    //Create getters and setters for attributes.
}

///////////////////// FILM CLASS /////////////////////////////////
//In this class you have 3 attributes: filmName, filmID and rentalTime(From class RentalTime.)
//All your attributes private.

class Film{

    private String filmName;
    private Integer filmID;
    private RentalTime rentalTime;


    //There is when we use other parameter encapsulated to have access without modify directly.
    /////////////////////////////////

    //Create valid constructor
    ///////////////////////////////7

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getFilmID() {
        return filmID;
    }

    public void setFilmID(Integer filmID) {
        this.filmID = filmID;
    }
}


////////////////////////// SERIE CLASS /////////////////////////////
//In this class you have 3 attributes: serieName, serieID and rentalTime(From class RentalTime.)
//All your attributes private.
class Series{

private String serieName;
private int serieID;
private RentalTime rentalTime;

    //There is when we use other object encapsulated to have access without modify directly.
//////////////////////////////////////////////////////

    //Create valid constructor for this class
////////////////////////////////////////////////////////

    public String getSerieName() {
        return serieName;
    }

    public void setSerieName(String serieName) {
        this.serieName = serieName;
    }

    public int getSerieID() {
        return serieID;
    }

    public void setSerieID(int serieID) {
        this.serieID = serieID;
    }
}



