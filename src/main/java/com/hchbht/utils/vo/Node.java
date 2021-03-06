package com.hchbht.utils.vo;

import java.io.Serializable;
import java.util.List;

import com.hchbht.utils.vo.Node;
import com.hchbht.utils.vo.NodeState;

public class Node implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public String id;    		//树的节点Id，区别于数据库中保存的数据Id。若要存储数据库数据的Id，添加新的Id属性；若想为节点设置路径，类中添加Path属性
    public String text;   		//节点名称
    public NodeState state;		//一个节点的初始状态。
    public List<Node> nodes;	//子节点，可以用递归的方法读取，方法在下一章会总结
	public Node() {
		
	}
	
	public Node(String id, String text, NodeState state, List<Node> nodes) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.nodes = nodes;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public NodeState getState() {
		return state;
	}
	public void setState(NodeState state) {
		this.state = state;
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	
	public String toString() {
		return "Node [id=" + id + ", text=" + text + ", state=" + state
				+ ", nodes=" + nodes + "]";
	}
}
