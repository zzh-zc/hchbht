package com.hchbht.utils.vo;

import java.io.Serializable;

public class NodeState implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Boolean checked;		//指示一个节点是否处于checked状态，用一个checkbox图标表示。
	private Boolean disabled;	//指示一个节点是否处于disabled状态。（不是selectable，expandable或checkable）
	private Boolean expanded;	//指示一个节点是否处于展开状态。
	private Boolean selected;	//指示一个节点是否可以被选择。
	public NodeState() {
		
	}
	
	public NodeState(Boolean checked, Boolean disabled, Boolean expanded,
			Boolean selected) {
		this.checked = checked;
		this.disabled = disabled;
		this.expanded = expanded;
		this.selected = selected;
	}
	
	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
	public String toString() {
		return "NodeState [checked=" + checked + ", disabled=" + disabled
				+ ", expanded=" + expanded + ", selected=" + selected + "]";
	}
	
}
