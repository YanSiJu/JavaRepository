package cn.csu.entity.command;

import cn.csu.entity.BoardScreen;

public class EditCommand extends AbstractCommand {

	public EditCommand(BoardScreen bodar) {
		super(bodar);
	}

	@Override
	public void execute() {
		
		board.edit();
	}

}
