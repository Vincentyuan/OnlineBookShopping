package cose.seu.entity;

import java.io.Serializable;

public class Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long TID;
	private Long typeParents;
	private String typeName;
	public Type(Long tID, Long typeParents, String typeName) {
		super();
		TID = tID;
		this.typeParents = typeParents;
		this.typeName = typeName;
	}
	public Type(Long typeParents, String typeName) {
		super();
		
		this.typeParents = typeParents;
		this.typeName = typeName;
	}
	public Type() {
		// TODO Auto-generated constructor stub
	}
	public Long getTID() {
		return TID;
	}
	public void setTID(Long tID) {
		TID = tID;
	}
	public Long getTypeParents() {
		return typeParents;
	}
	public void setTypeParents(Long typeParents) {
		this.typeParents = typeParents;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "Type [TID=" + TID + ", typeParents=" + typeParents
				+ ", typeName=" + typeName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TID == null) ? 0 : TID.hashCode());
		result = prime * result
				+ ((typeName == null) ? 0 : typeName.hashCode());
		result = prime * result
				+ ((typeParents == null) ? 0 : typeParents.hashCode());
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
		Type other = (Type) obj;
		if (TID == null) {
			if (other.TID != null)
				return false;
		} else if (!TID.equals(other.TID))
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		if (typeParents == null) {
			if (other.typeParents != null)
				return false;
		} else if (!typeParents.equals(other.typeParents))
			return false;
		return true;
	}
	
	
}
