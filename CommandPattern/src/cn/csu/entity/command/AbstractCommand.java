package cn.csu.entity.command;

import cn.csu.entity.BoardScreen;

public abstract class AbstractCommand {

	protected BoardScreen board;

	public AbstractCommand(BoardScreen board) {

		this.board = board;
	}

	public BoardScreen getBoard() {
		return board;
	}

	public void setBodar(BoardScreen board) {
		this.board = board;
	}

	public abstract void execute();

}
