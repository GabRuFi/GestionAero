package pkgClasse;

public class Resource 
{
	String name;
	Integer index;
	
	public void get(Integer avionID)
	{
		System.out.println(index + "." + name + " par " + avionID + ".Avion: get()");		
		return;
	}
	
	public void put(Integer avionID)
	{
		System.out.println(index + "." + name + " par " + avionID + ".Avion: put()");
		return;
	}
	
	public void exec()
	{
		get(0);
		put(0);		
	}
	
	public Resource(String name, int i)
	{
		this.name = name;
		this.index = i;		
	}
	
	/*public void main(String[] args) {
		Resource item = new Resource("res", 1);
		item.exec();
	}	*/
}
