package org.docs.controller;

public class PageInfo {
	private String bottom;
	public boolean redirect;
	public PageInfo(String bottom, boolean redirect) {
		super();
		this.bottom = bottom;
		this.redirect = redirect;
	}
	public String getBottom() {
		return bottom;
	}
	public void setBottom(String bottom) {
		this.bottom = bottom;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	@Override
	public String toString() {
		return "PageInfo [bottom = " + bottom + ", redirect =" + redirect + "]";
		
	}
}
