package client.command.commands.gm0;

import client.MapleClient;
import client.command.Command;

/**
 *
 * @author Troy Schultz
 */

public class RebirthCygnusCommand extends Command { 
{
    setDescription("Reset : Lvl to 1 with all ap + 5 bonus ap and previously leveled skills/passives saved on keys");
}
    @Override
public void execute(MapleClient c, String[] params) {
    c.getPlayer().executeReborn('C');
    }
}