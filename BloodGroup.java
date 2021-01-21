package model;

public class BloodGroup {
  private String BloodGroup;
  private double NoOfUnits;
  public BloodGroup() {}

public BloodGroup(String bloodGroup, double noOfUnits) {
	super();
	this.BloodGroup = bloodGroup;
	this.NoOfUnits = noOfUnits;
}

public String getBloodGroup() {
	return BloodGroup;
}
public void setBloodGroup(String bloodGroup) {
	this.BloodGroup = bloodGroup;
}
public double getNoOfUnits() {
	return NoOfUnits;
}
public void setNoOfUnits(int noOfUnits) {
	this.NoOfUnits = noOfUnits;
}
@Override
public String toString() {
	return "BloodGroup [BloodGroup=" + BloodGroup + ", NoOfUnits=" + NoOfUnits + "]";
}
  
	
	
}
