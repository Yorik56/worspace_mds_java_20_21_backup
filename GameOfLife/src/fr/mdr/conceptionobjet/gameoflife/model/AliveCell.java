package fr.mdr.conceptionobjet.gameoflife.model;

public class AliveCell implements Cell {

	@Override
	public Cell newGeneration(int nbNeighbours) {
		if (nbNeighbours == 2 || nbNeighbours == 3) {
			return new AliveCell();
		} else {
			return new DeadCell();
		}
	}

	@Override
	public String getAString() {
		// TODO Auto-generated method stub
		return " # ";
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return true;
	}

}
