package client.command.commands.gm0;

import client.MapleClient;
import client.command.Command;

/**
 *
 * @author Troy Schultz
 */

public class RebirthExplorerCommand extends Command { 
{
    setDescription("");
}
    @Override
public void execute(MapleClient c, String[] params) {
    c.getPlayer().executeReborn('E');
    }
}