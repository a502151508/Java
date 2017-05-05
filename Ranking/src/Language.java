
public class Language {
	private String rank;
	private String proName;
	private String ratings;
	Language(String rank,String proName,String ratings){
		this.rank=rank;
		this.proName=proName;
		this.ratings=ratings;
	}
	String outputLanguage(){
		if(proName.length()<=7)
			return (rank +  "\t" + proName + "\t\t\t" + ratings );
			else if(proName.length()>12)
				return (rank +  "\t" + proName + "\t" + ratings );
			else
				return (rank +  "\t" + proName + "\t\t" + ratings );
			
	}
}
