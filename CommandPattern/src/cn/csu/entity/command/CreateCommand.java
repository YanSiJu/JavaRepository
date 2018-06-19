package cn.csu.entity.command;

import cn.csu.entity.BoardScreen;

public class CreateCommand extends AbstractCommand {

	public CreateCommand(BoardScreen board) {
		super(board);
	}

	@Override
	public void execute() {
		board.create();
	}

}
