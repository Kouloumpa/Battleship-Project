import java.util.Scanner;
import java.io.Console;
import java.util.Random;

public class Game{
    
    public static void main(String[] args){
        //voithitikos pinakas gia na elenxoume poio antikeimeno tha dimiourgithei
        String[][] shiparray = {
            {"Carrier","Battleship","Submarine","Cruiser","Destroyer"},
            {"5","4","3","3","2"}
            };
        Scanner reader = new Scanner(System.in);    //dimiourgia metavlitis gia na pairnoume times apo ton xrhsth
        System.out.println("Welcome to Battleship . What is your name?");
        String name = reader.nextLine();
        Player myplayer = new Player( name );   //dimiourgia stigmiotipou neou paixti 
        Player bot = new Player("Computer");    //dimiourgia stigmiotipou computer
        Board board = new Board();              //dimiourgia pinaka paixtwn
   

        String c;   // metavliti gia na apothikeusoume thn apanthsh tou xristi yes/no
        int hv;     // metavliti gia na apothikeusoume thn apanthsh tou xristi h/v
        do{
            System.out.println("Do you want to place your ships random?");
            System.out.println("Please answer yes or no");
            c = reader.nextLine();
        }
        while( !(c.equals("yes") ) && !(c.equals("no") ) ) ; //elenxos mono apodektwn timwn yes h no
     
        if(c.equals("yes")) // an o paixtis epilexei na topothetisei ta ploia tou tuxaia
        {
            Board.placeAllShips(Board.MyBoard , false);          // tuxaia topothetisi ploion ston pinaka tou paixti
            Board.placeAllShips(Board.PcBoard , false);         // tuxaia topothetisi ploion ston pinaka tou computer
            Board.drawboards(Board.MyBoard , Board.PcBoard);   // ektypwsh twn 2 pinakwn
        }
        else                // an o paixtis epilexei to pou tha topothetisei to kathe ploio
          {
                boolean foo = true;                       // metavliti elenxou exeresewn 
                boolean foa = true;                      // metavliti elenxou while loop
                boolean carrierExist  = false;          // metavlhtes elenxou an exoun idi dhmiourgithei ta stigmiotupa twn ploiwn
                boolean battleshipExist  = false;
                boolean submarineExist  = false; 
                boolean cruiserExist  = false;
                boolean destroyerExist = false;
           while( foa == true){
               for(int i=0 ; i < 5 ; i++)
               {
                    if(shiparray[0][i].equals("Carrier") && carrierExist == false) 
                    //  elenxoume an idi exei topothetithei to ploio ston pinaka
                    {       
                        do{
                             System.out.println("Do you want to place your ship " + shiparray[0][i] +  " horizontal or vertical?");
                             System.out.println("Please answer h for horizontal or v for vertical");
                             c = reader.nextLine();
                        }
                        while( !(c.equals("h") ) && !(c.equals("v") ) ) ;   // epitreptes apanthseis mono h ή v
                        if (c.equals("h")) { hv = 1;}
                        else { hv = 0;}
                        System.out.println("Give the coordinates for  " + shiparray[0][i] + " with  " + shiparray[1][i] + " tiles");
                        int coordarray[] = getInput();
                        foo = Ship.OversizeExeption(coordarray[0] , coordarray[1] , hv , 5 , true);
                        if(foo == false) {  // elenxos tou ti epistrefei h OversizeExeption
                            break;          // an uparxei exeption termatizei h for alla logo ths while xanaarxizei apo thn arxh
                        }
                        foo = Ship.OverlapExeption(coordarray[0] , coordarray[1] , Board.MyBoard , hv , 5 , true);
                        if(foo == false) {  // elenxos tou ti epistrefei h OverlapExeption
                            break; 
                        }
                        Carrier mycarrier = new Carrier(coordarray[0] , coordarray[1] , hv );  //dimiourgia stigmiotupou ploiou
                        mycarrier.placeShip( coordarray[0] ,coordarray[1] ,hv ,Board.MyBoard, 5 , true); //topothetisi ploiou ston pinaka
                        Board.drawboards(Board.MyBoard , Board.PcBoard);                // ektupwsh pinakwn 
                        carrierExist = true;                                            // ananewsh pws to stigmiotipo exei dimiourgithei
                    }
                    if(shiparray[0][i].equals("Battleship") && battleshipExist == false)
                    {  
                        do{
                        	System.out.println("Do you want to place your ship " + shiparray[0][i] +  " horizontal or vertical?");
                            System.out.println("Please answer h for horizontal or v for vertical");
                            c = reader.nextLine();
                        }
                        while( !(c.equals("h") ) && !(c.equals("v") ) ) ;
                        if (c.equals("h")) { hv = 1;}
                        else { hv = 0;}
                        System.out.println("Give the coordinates for  " + shiparray[0][i] + " with  " + shiparray[1][i] + " tiles");
                        int coordarray[] = getInput();
                        foo = Ship.OversizeExeption(coordarray[0] , coordarray[1] , hv , 4 , true);
                        if(foo == false) {break;}
                        foo = Ship.OverlapExeption(coordarray[0] , coordarray[1] , Board.MyBoard , hv , 4 , true);
                        if(foo == false) {break;}
                        Battleship mybattleship = new Battleship(coordarray[0] , coordarray[1] , hv );
                        mybattleship.placeShip( coordarray[0] ,coordarray[1] ,hv ,Board.MyBoard, 4 , true);
                        Board.drawboards(Board.MyBoard , Board.PcBoard);
                        battleshipExist = true;
                    }
                    if(shiparray[0][i].equals("Submarine") && submarineExist == false)
                    {  
                        do{
                        	System.out.println("Do you want to place your ship " + shiparray[0][i] +  " horizontal or vertical?");
                            System.out.println("Please answer h for horizontal or v for vertical");
                            c = reader.nextLine();
                        }
                        while( !(c.equals("h") ) && !(c.equals("v") ) ) ;
                        if (c.equals("h")) { hv = 1;}
                        else { hv = 0;}
                        System.out.println("Give the coordinates for  " + shiparray[0][i] + " with  " + shiparray[1][i] + " tiles");
                        int coordarray[] = getInput();
                        foo = Ship.OversizeExeption(coordarray[0] , coordarray[1] , hv , 3 , true);
                        if(foo == false) {break;}
                        foo = Ship.OverlapExeption(coordarray[0] , coordarray[1] , Board.MyBoard , hv , 3 , true);
                        if(foo == false) {break;} 
                        Submarine mysubmarine = new Submarine(coordarray[0] , coordarray[1] , hv ); 
                        mysubmarine.placeShip( coordarray[0] ,coordarray[1] ,hv ,Board.MyBoard, 3 , true);
                        Board.drawboards(Board.MyBoard , Board.PcBoard);
                        submarineExist = true;
                    }
                    if(shiparray[0][i].equals("Cruiser") && cruiserExist == false)
                    {
                        do{
                        	System.out.println("Do you want to place your ship " + shiparray[0][i] +  " horizontal or vertical?");
                            System.out.println("Please answer h for horizontal or v for vertical");
                            c = reader.nextLine();
                        }
                        while( !(c.equals("h") ) && !(c.equals("v") ) ) ;
                        if (c.equals("h")) { hv = 1;}
                        else { hv = 0;}
                        System.out.println("Give the coordinates for  " + shiparray[0][i] + " with  " + shiparray[1][i] + " tiles");
                        int coordarray[] = getInput();
                        foo = Ship.OversizeExeption(coordarray[0] , coordarray[1] , hv , 3 , true);
                        if(foo == false) {break;}
                        foo = Ship.OverlapExeption(coordarray[0] , coordarray[1] , Board.MyBoard , hv , 3 , true);
                        if(foo == false) {break;} 
                        Cruiser mycruiser = new Cruiser(coordarray[0] , coordarray[1] , hv );
                        mycruiser.placeShip( coordarray[0] ,coordarray[1] ,hv ,Board.MyBoard, 3 , true);
                        Board.drawboards(Board.MyBoard , Board.PcBoard);
                        cruiserExist = true;
                    }
                    if(shiparray[0][i].equals("Destroyer") && destroyerExist == false){
                        do{
                        	System.out.println("Do you want to place your ship " + shiparray[0][i] +  " horizontal or vertical?");
                            System.out.println("Please answer h for horizontal or v for vertical");
                            c = reader.nextLine();
                        }
                        while( !(c.equals("h") ) && !(c.equals("v") ) ) ;
                        if (c.equals("h")) { hv = 1;}
                        else { hv = 0;}
                        System.out.println("Give the coordinates for  " + shiparray[0][i] + " with  " + shiparray[1][i] + " tiles");
                        int coordarray[] = getInput();
                        foo = Ship.OversizeExeption(coordarray[0] , coordarray[1] , hv , 2 , true);
                        if(foo == false) {break;}
                        foo = Ship.OverlapExeption(coordarray[0] , coordarray[1] , Board.MyBoard , hv , 2 , true);
                        if(foo == false) {break;}
                        Destroyer mydestroyer = new Destroyer(coordarray[0] , coordarray[1] , hv );
                        mydestroyer.placeShip( coordarray[0] ,coordarray[1] ,hv ,Board.MyBoard, 2 , true);
                        Board.drawboards(Board.MyBoard , Board.PcBoard);
                        destroyerExist = true;
                    }
                    if(i == 4) { foa = false;}  // otan teleiwsei kai h pempth epanalipsi tou for diladi exoun dimiourgithei kai topothetithei ola ta ploia tou paixti vges apo thn while
               }
             }
             Board.placeAllShips(Board.PcBoard , false);        //dimiourgia twn ploiwn tou computer
             Board.drawboards(Board.MyBoard , Board.PcBoard);   // ektupwsh twn pinakwn
        }
        String p = "";  // voithitikh metavliti gia na elenxoume poios paixtis kerdise
        while(Board.allShipsSunk(Board.MyBoard) == false && Board.allShipsSunk(Board.PcBoard) == false) // elenxos an kapoios paixtis exei rixei 17 voles HIT
        {
            p = myplayer.getName() ;
            System.out.println("Please give strike coordinates");
            int hitArray[] = getInput();                // o paixtis dinei suntetagmenes xtipimatos
            myplayer.fire(Board.PcBoard , hitArray);    // pragmatopoihsh volhs ston pinaka tou computer
            if(Board.allShipsSunk(Board.PcBoard) == true ) { 
                break;  // an h volh tou paixti ekane ton metrhth volwn HIt = 17 to paixnidi termatizei kai den rixnei volh o computer
            }
            bot.fire(Board.MyBoard , getRandInput());   // pragmatopoihsh volhs ston pinaka tou paixti me tuxaies suntetagmenes
            p = bot.getName();
            Board.drawboards(Board.MyBoard , Board.PcBoard);       //ektupwsh pinakwn        
        } 
        System.out.println( "Player "  + p + " won!");
        myplayer.getStats();    // ektupwnoume ta statistika tou paixti
        bot.getStats();        // eltupwnoume ta statistika tou computer
    }
        
    //methodos gia na dinei suntetagmenes o paixtis
    public static int[] getInput(){
            Scanner reader = new Scanner(System.in);   
            int[] array = new int[2];
            do{
                System.out.println("Please give coordinates inside the 7x7 board");
                array[0] = reader.nextInt();
                array[1] = reader.nextInt();
              }   while(array[0] >= 7 || array[1] >= 7);
            return array;
    }
    
    //methodos dimiourgias tuxaiwn suntetagmenwn 
    public static int[] getRandInput(){
             int randomX = (int )(Math.random() * 7 + 0); // tuxaios arithmos apo 0 ews 6 ([int](0.00 - 0.99)*7)
             int randomY = (int )(Math.random() * 7 + 0);
             int[] randarray = new int[2];
             randarray[0] = randomX;
             randarray[1] = randomY;
             return randarray;
    }
}