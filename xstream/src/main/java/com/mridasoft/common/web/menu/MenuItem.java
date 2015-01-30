package com.mridasoft.common.web.menu;

import java.util.ArrayList;

public class MenuItem {

	private String id;
	private String url = "#";
	private boolean children = false;
	
	private ArrayList<MenuItem> subMenu = null;
	
	public String getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public boolean hasChildren() {
		return children;
	}

	
	public ArrayList<MenuItem> getSubMenu() {
		return subMenu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((subMenu == null) ? 0 : subMenu.hashCode());
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
		MenuItem other = (MenuItem) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (subMenu == null) {
			if (other.subMenu != null)
				return false;
		} else if (!subMenu.equals(other.subMenu))
			return false;
		return true;
	}
	
	public static String toString(MenuItem itm , int depth) {

		StringBuilder sb = new StringBuilder();

		StringBuilder indent = new StringBuilder();

		for (int d = 0; d < depth; d++)
			indent.append("\t");

		sb.append(indent).append(itm.getId()).append("[")
				.append(itm.getUrl()).append(",")
				.append(itm.getSubMenu().size()).append("]--->\n");

		for (MenuItem sub : itm.getSubMenu()) {

			if (sub == null)
				continue; // ensure size problem

			sb.append(indent).append(toString(sub,depth + 1));
		}

		return sb.toString();
	}

	@Override
	public String toString() {
		return toString(this,0);
	}

	/* Testing builder with fast code */

	private MenuItem(Builder builder) {
		this.id = builder.id;
		this.url = builder.url;
		this.subMenu = new ArrayList<MenuItem>();
		{
			subMenu.addAll(builder.subMenu);
		}
		this.children = subMenu !=null && !subMenu.isEmpty();
	}

	public static class Builder {
		private String id;
		private String url;
		private ArrayList<MenuItem> subMenu = new ArrayList<MenuItem>();

		public Builder withId(String id) {
			this.id = id;
			return this;
		}

		public Builder withUrl(String href) {
			this.url = href;
			return this;
		}

		public Builder withChildMenu(MenuItem subMenu) {
			this.subMenu.add(subMenu);
			return this;
		}

		public MenuItem build() {
			return new MenuItem(this);
		}
		
		public ArrayList<? extends MenuItem> getSubMenu() {
			return subMenu;
		}
	}

}
