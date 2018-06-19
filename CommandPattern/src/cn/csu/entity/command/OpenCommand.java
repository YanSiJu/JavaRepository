package cn.csu.entity.command;

import cn.csu.entity.BoardScreen;

public class OpenCommand extends AbstractCommand {

	public OpenCommand(BoardScreen bodar) {
		super(bodar);
		
	}

	@Override
	public void execute() {
	
		board.open();
	}

}
