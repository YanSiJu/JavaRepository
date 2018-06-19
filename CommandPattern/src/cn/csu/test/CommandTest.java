package cn.csu.test;

import java.util.List;
import org.junit.Test;
import cn.csu.entity.BoardScreen;
import cn.csu.entity.Menu;
import cn.csu.entity.MenuItem;
import cn.csu.entity.command.AbstractCommand;
import cn.csu.entity.command.CreateCommand;
import cn.csu.entity.command.EditCommand;
import cn.csu.entity.command.OpenCommand;

public class CommandTest {

	@Test
	public void test() {

		BoardScreen board = new BoardScreen();

		AbstractCommand openComand = new OpenCommand(board);
		AbstractCommand editComand = new EditCommand(board);
		AbstractCommand createComand = new CreateCommand(board);

		Menu menu = new Menu();

		menu.addMenuItem(new MenuItem(createComand));
		menu.addMenuItem(new MenuItem(openComand));
		menu.addMenuItem(new MenuItem(editComand));

		List<MenuItem> items = menu.getMenuItems();
		for (MenuItem item : items) {
			item.click();
		}

	}
}
