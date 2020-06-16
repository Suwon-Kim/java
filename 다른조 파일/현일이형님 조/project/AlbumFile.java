public class AlbumFile {
	private String filePath;
	private String hashtag;
	private String explanation;

	public AlbumFile(String filePath, String hashtag, String explanation) {
		super();
		this.filePath = filePath;
		this.hashtag = hashtag;
		this.explanation = explanation;
	}
	public AlbumFile(String filePath) {
		this.filePath = filePath;
		this.hashtag = hashtag;
		this.explanation = explanation;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
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
		AlbumFile other = (AlbumFile) obj;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AlbumFile [filePath=" + filePath + ", hashtag=" + hashtag + ", explanation=" + explanation + "]";
	}

}	
