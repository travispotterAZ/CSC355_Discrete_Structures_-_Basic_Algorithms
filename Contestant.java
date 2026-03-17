public class Contestant{
    private String contestantName;
    private int contestantScore;

    public Contestant(){ //This is the default constructor for when a new contestent object is created
        contestantName = "noName";
        contestantScore = -1;
    }

    public Contestant(String inputName){ //This is an overloaded constructor that will be called when a new object is created and 1 parameters are passed
        contestantName = inputName;
        contestantScore = -1;
    }

    public Contestant(String inputName, int inputScore){ //This is an overloaded constructor that will be called when a new object is created and 2 parameters are passed
        contestantName = inputName;
        contestantScore = inputScore;
    }

    public String getName(){ //This returns the name of the contestant
        return contestantName;
    }

    public int getScore(){ //This returns the contestants score
        return contestantScore;
    }

    public int compareTo(Contestant o){
        if(contestantScore > o.getScore()){
            return 1; //return 1 if there is a "greater than" relationship
        } 
        else if(contestantScore < o.getScore()){
            return -1; //return -1 if there is a "Less than" relationship
        }
        else{ 
            if(contestantName.compareTo(o.getName()) == 0){
                return 0; //return 0 if there is a "equals" relationship (name and score are the same)
            }
            else if(contestantName.compareTo(o.getName()) < 0){
                return 1; //the passed in object is "less than" the contestant name this means alphabeticallty it will come first
            }
            else{
                return -1; //The passed in object is "greater than" the contestant name which means that the passed in object comes after the contestant name alphabetically
            }
        } //This uses the .compareTo finction to compare the strings if the scores are the same
    }

    public String toString(){
        String contestantString;
        contestantString = contestantName + ": " + contestantScore;
        return contestantString;
    }


}
