import java.util.Random;
public class Board{
    public static Tile[][] MyBoard = new Tile[7][7];
    public static Tile[][] PcBoard = new Tile[7][7];
    
    //Dimiourgos pinaka
    public Board( ){     
        System.out.println("  -  -  YOU   -   -             -  -  OPPONENT -  -");
        System.out.println(" 0  1  2  3  4  5  6            0  1  2  3  4  5  6  ");
        for (int i=0; i<7; i++){
        System.out.print(i);
        for (int j=0; j<7; j ++){
            MyBoard[i][j] = new Tile(i , j , Tile.Type.Sea);
            MyBoard[i][j].draw(i , j , false);
        }
        System.out.print("  \t");
        for (int k = 0; k<7; k++){
            PcBoard[i][k] = new Tile(i , k , Tile.Type.Sea);
            PcBoard[i][k].draw(i , k , true);
        }
        System.out.println();
        }
        System.out.println();
    }
    
    //methodos ektiposis pinakwn
    public static void drawboards( Tile MyBoard[][] , Tile PcBoard[][] ){
        System.out.println("  -  -   YOU   -   -              -  -  OPPONENT -  -");
        System.out.println("  0  1  2  3  4  5  6             0  1  2  3  4  5  6  ");
        for (int i=0; i<7; i++){
        System.out.print(i + " ");
        for (int j=0; j<7; j ++){
            MyBoard[i][j].draw(i , j , false);
        }
        System.out.print("  \t" + i + " ");
        
        for (int k = 0; k<7; k++){
            PcBoard[i][k].draw(i , k , true);
        }
        System.out.println();
        }
        System.out.println();
    }   
    
    //methodos tixaias topothetisis ploiwn
    
     public static void placeAllShips( Tile Board[][]  ,boolean verbose){
         int randomX ;
         int randomY ;
         int randomOrient ; 
         boolean foo = true;    // metavliti gia na elenxoume ta exceptions
         boolean nue = true;    // metavliti gia na elenxoume tin while
         
         // mia while gia kathe tupo ploiou 
         while(foo == true){
                        
              randomX = (int )(Math.random() * 7 + 0);
              randomY = (int )(Math.random() * 7 + 0);
              randomOrient = (int ) (Math.random() * 2 + 0);
              nue = Ship.OversizeExeption(randomX , randomY , randomOrient , 5 , verbose);
              if(nue == false) {continue;}  // an iparxei exception xanaprospathei me nees tixaies times
              nue = Ship.OverlapExeption(randomX , randomY , Board , randomOrient , 5 , verbose);
              if(nue == false) {continue;}
              Carrier mycarrier = new Carrier(randomX , randomY , randomOrient );
              mycarrier.placeShip( randomX , randomY , randomOrient , Board, 5 , verbose);
                       
              foo = false;
         }
         foo = true;
         while(foo == true){
                        
              randomX = (int )(Math.random() * 7 + 0);
              randomY = (int )(Math.random() * 7 + 0);
              randomOrient = (int ) (Math.random() * 2 + 0);
              nue = Ship.OversizeExeption(randomX , randomY , randomOrient , 4 , verbose);
              if(nue == false) {continue;}
              nue = Ship.OverlapExeption(randomX , randomY , Board , randomOrient , 4 , verbose);
              if(nue == false) {continue;}
              Battleship myBattleship = new Battleship(randomX , randomY , randomOrient );
              myBattleship.placeShip( randomX , randomY , randomOrient , Board, 4 , verbose);
              foo = false;
                          
         }
         foo = true;
         while(foo == true){
                                        
              randomX = (int )(Math.random() * 7 + 0);
              randomY = (int )(Math.random() * 7 + 0);
              randomOrient = (int ) (Math.random() * 2 + 0);
              nue = Ship.OversizeExeption(randomX , randomY , randomOrient , 3 , verbose);
              if(nue == false) {continue;}
              nue = Ship.OverlapExeption(randomX , randomY , Board , randomOrient , 3 , verbose);
              if(nue == false) {continue;}
              Submarine mySubmarine = new Submarine(randomX , randomY , randomOrient );
              mySubmarine.placeShip( randomX , randomY , randomOrient , Board, 3 , verbose);
              foo = false;
                                         
         }
         foo = true;
         while(foo == true){
                                        
              randomX = (int )(Math.random() * 7 + 0);
              randomY = (int )(Math.random() * 7 + 0);
              randomOrient = (int ) (Math.random() * 2 + 0);
              nue = Ship.OversizeExeption(randomX , randomY , randomOrient , 3 , verbose);
              if(nue == false) {continue;}
              nue = Ship.OverlapExeption(randomX , randomY , Board , randomOrient , 3 , verbose);
              if(nue == false) {continue;}
              Cruiser mycruiser = new Cruiser(randomX , randomY , randomOrient );
              mycruiser.placeShip( randomX , randomY , randomOrient , Board, 3 , verbose);
              foo = false;
                                         
         }
         foo = true;
         while(foo == true){
                                        
              randomX = (int )(Math.random() * 7 + 0);
              randomY = (int )(Math.random() * 7 + 0);
              randomOrient = (int ) (Math.random() * 2 + 0);
              nue = Ship.OversizeExeption(randomX , randomY , randomOrient , 2 , verbose);
              if(nue == false) {continue;}
              nue = Ship.OverlapExeption(randomX , randomY , Board , randomOrient , 2 , verbose);
              if(nue == false) {continue;}
              Destroyer myDestroyer = new Destroyer(randomX , randomY , randomOrient );
              myDestroyer.placeShip( randomX , randomY , randomOrient , Board, 2 , verbose);
              foo = false;
                                        
         }
    }
    // methodos gia ton elenxo lixis tou paixnidiou
    public static boolean allShipsSunk(Tile Board[][]){
        int counter = 0; // metavliti pou elenxei ta kelia tupou HIT
        boolean endgame = false;    // metavliti pou epistrefei true otan se ena pinaka uparxoun 17 kelia HIT
        for(int i = 0 ; i < 7 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                if(Board[i][j].getType() == Tile.Type.Hit) counter += 1;
            }
        }
        if(counter == 17) endgame = true;
        return endgame;
    }
}

 