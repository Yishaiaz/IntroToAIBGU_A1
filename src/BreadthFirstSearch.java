import javafx.beans.binding.ListBinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
	LinkedList<ASearchNode> openList;
	LinkedList<ASearchNode> closedList;
	
	@Override
	public String getSolverName() 
	{
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		openList = new LinkedList<>();
		closedList = new LinkedList<>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		if(openList.contains(node)){
			return openList.get(openList.indexOf(node));
		}
		return  openList.contains(node)? openList.get(openList.indexOf(node)): null;
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	) 
	{
		return openList.contains(node);
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		return closedList.contains(node);
	}

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{
		openList.add(node);
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
 		closedList.add(node);
	}

	@Override
	public int openSize() 
	{
		return openList.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return openList.poll();
	}

	

}
