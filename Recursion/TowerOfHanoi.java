package Recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {

        // print the instruction to move 3 disk
        // from tower A to B with the help of C

         printTowerOfHanoiInstruction(3,'A','B','C') ;

    }

    public static  void printTowerOfHanoiInstruction(int numberOfDisk , char ot , char dt , char ht) {
        if(numberOfDisk==0) {
            return;
        }
        // Faith :- This function is able to move small number of disk from
        //          one tower to another with the help of other tower
        printTowerOfHanoiInstruction(numberOfDisk-1,ot,ht,dt);
        // Now we will move last dist from "ot" to "dt "
        System.out.println(numberOfDisk +"[" + ot + "-->"+ dt +"]");

        printTowerOfHanoiInstruction(numberOfDisk-1,ht,dt,ot);
    }

}