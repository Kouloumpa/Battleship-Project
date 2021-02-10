public class Player{
    private  int totalFire = 0; 
    private  int totalMiss = 0; 
    private  int totalHit = 0; 
    private  int totalRehit = 0 ; 
    private  String name ; 
  
    public Player(String name){
        this.name = name;
    }
    
    public  String getName(){return name;}
    public void setName(String name){this.name = name;}
    
    // methodos pragmatopoihsis volis
    public  void fire(Tile fireBoard[][], int coord[])
    {
        // elenxos prohgoumenhs timis keliou prin to fire
        if(fireBoard[coord[0]][coord[1]].getType() == Tile.Type.Miss)
            {
                System.out.println(getName() + " Already Miss");
                totalFire += 1;
                totalMiss += 1;
                totalRehit += 1;
            }
        if(fireBoard[coord[0]][coord[1]].getType() == Tile.Type.Hit)
            {
                System.out.println(getName() + " Already Hit");
                totalFire += 1;
                totalMiss += 1;
                totalRehit += 1;
            }
        if(fireBoard[coord[0]][coord[1]].getType() == Tile.Type.Sea)
            {fireBoard[coord[0]][coord[1]].setType(Tile.Type.Miss);
                System.out.println(getName() + " Miss");
                totalFire += 1;
                totalMiss += 1;
            }
        if(fireBoard[coord[0]][coord[1]].getType() == Tile.Type.Ship)
            {fireBoard[coord[0]][coord[1]].setType(Tile.Type.Hit);
                System.out.println(getName() + " Hit");
                totalFire += 1;
                totalHit += 1;
            }
        
        }
    //methodos ektypwsis statistikwn
    public void getStats(){
        System.out.println("Stats of player " + getName() + " :");
        System.out.println("Total fire : " + totalFire );
        System.out.println("Total Miss : " + totalMiss );
        System.out.println("Total Hit : " + totalHit );
        System.out.println("Total Rehit : " + totalRehit );
    }
}