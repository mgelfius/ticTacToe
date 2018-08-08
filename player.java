public class player{

    boolean isHuman;
    String name;

    public player(boolean isHuman, String name){
        System.out.println("New player! Human = " + isHuman + ". Their name is " + name);
        this.isHuman = isHuman;
        this.name = name;
    }

    public void setHuman(boolean isHuman){
        this.isHuman = isHuman;
    }

    public boolean getHuman(){
        return isHuman;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}