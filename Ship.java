 public abstract class Ship {
    private int startTileX ,startTileY , orient , size ;
    private static boolean verbose ; 
    
    public Ship(int startTileX ,int startTileY ,int orient){
        this.startTileX = startTileX ;
        this.startTileY = startTileY ; 
        this.orient = orient ;
   }
    
    //methodos topothetisis ploiou ston pinaka
    public void placeShip(int startTileX ,int startTileY , int orient,Tile myTiles[][],int size, boolean verbose)
    {
        if (orient ==0 ){
            for (int i=0; i<size; i++) { 
                if (myTiles[startTileX+i][startTileY].getType() == Tile.Type.Sea){
                        myTiles[startTileX+i][startTileY].setType(Tile.Type.Ship);
                }
            } 
        }
         
        else if ( orient == 1) 
        {
            for(int i=0; i<size; i++) { 
               if (myTiles[startTileX][startTileY + i].getType() == Tile.Type.Sea){
                        myTiles[startTileX][startTileY + i].setType(Tile.Type.Ship);
                }
            }
        }
    }
    
    //methodos elenxou an to ploio xoraei ston pinaka
    public static boolean OversizeExeption(int startTileX ,int startTileY , int orient ,int size , boolean verbose){
        boolean check = false;
       if (orient == 0){
             if ((startTileX + size) < 8 ) {
                 check = true ;
             }
             else {check = false ; if(verbose ==  true){System.out.println("Not enough space on the board");} } // elenxos an prepei na ektupwthei h oxi to sfalma
       }
       if (orient == 1){
             if ((startTileY + size) < 8 ){
               check = true ; 
             }
             else {check = false ; if(verbose ==  true){ System.out.println("Not enough space on the board");}} // elenxos an prepei na ektupwthei h oxi to sfalma
       } 
       return check ; 
    }
    
    //methodos elenxou an ena ploio paei na topothetithei panw se allo
    public static boolean OverlapExeption(int startTileX , int startTileY , Tile myBoard[][], int orient , int size , boolean verbose){
        boolean    overlapcheck = true; 
        if (orient == 0){
           for(int i = 0 ; i < size ; i++){
               if ( myBoard[startTileX + i][startTileY].getType() == Tile.Type.Ship ){
                    overlapcheck = false; 
                    if(verbose ==  true){System.out.println("You cant place a ship on top of another");} // elenxos an prepei na ektupwthei h oxi to sfalma
                    break;
               }
           }     
        } 
        if (orient == 1){
           for(int i = 0 ; i < size ; i++){
               if ( myBoard[startTileX][startTileY + i].getType() == Tile.Type.Ship ){
                    overlapcheck = false;
                    if(verbose ==  true){System.out.println("You cant place a ship on top of another");} // elenxos an prepei na ektupwthei h oxi to sfalma
                    break;
               }
           }        
        }
        
        return overlapcheck; 
    }
  }
    
