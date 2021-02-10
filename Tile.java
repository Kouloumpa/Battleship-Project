public class Tile {
    private Type type = Type.Sea;
    private int x , y ; 
    public enum Type {
        Sea , Ship , Hit , Miss ;
    }
    public void setX(int x){ this.x = x ; }
    public int getX() { return x ;}
    public void setY(int y){ this.y = y ;}
    public int getY() { return y ;}
    public void setType(Type p){this.type = p ;}
    public Type getType() { return type ;}
    
    public Tile (int x , int y , Type type){
        this.x = x;
        this.y = y;
        this.type = type;
    }
    //methodos ektypwshs timis keliou
    public void draw(int x , int y , boolean hidden ) {
       if(hidden == false){
           if(this.type == Type.Sea){System.out.print("~  ");}
           else if(this.type == Type.Ship){System.out.print("s  ");}
           else if(this.type == Type.Hit){System.out.print("X  ");}
           else if(this.type == Type.Miss){System.out.print("O  ");}
       }
       else if (hidden == true){
           if(this.type == Type.Sea){System.out.print("~  ");}
           else if(this.type == Type.Ship){System.out.print("~  ");}
           else if(this.type == Type.Hit){System.out.print("X  ");}
           else if(this.type == Type.Miss){System.out.print("O  ");}
       }
    }
}