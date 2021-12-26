/**
 *
 * @author Troy Schultz
 */
package client.command.commands.gm4;

import client.command.Command;
import client.MapleClient;
import client.MapleCharacter;
import server.life.MapleLifeFactory;

public class AnegoCommand extends Command {
    {
        setDescription("");
    }

    @Override
    public void execute(MapleClient c, String[] params) {
        MapleCharacter player = c.getPlayer();
        player.getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9400121), player.getPosition());

    }
}