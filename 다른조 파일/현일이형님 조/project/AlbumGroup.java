import java.util.ArrayList;

public class AlbumGroup {
	private String name;
	private ArrayList<String> pictureInGroup;
	
	public AlbumGroup(String name) {
		this.name = name;
		this.pictureInGroup = new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getPictureInGroup() {
		return pictureInGroup;
	}
	public void setPictureInGroup(ArrayList<String> pictureInGroup) {
		this.pictureInGroup = pictureInGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlbumGroup other = (AlbumGroup) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumGroup [name=" + name + ", pictureInGroup=" + pictureInGroup + "]";
	}


	
}
