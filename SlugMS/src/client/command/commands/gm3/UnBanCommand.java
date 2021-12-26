/*
    This file is part of the SlugMS MapleStory Server, commands OdinMS-based
    Copyleft (L) 2016 - 2019 RonanLana

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

/*
   @Author: Arthur L - Refactored command content into modules
*/
package client.command.commands.gm3;

import client.command.Command;
import client.MapleClient;
import client.MapleCharacter;
import tools.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UnBanCommand extends Command {
    {
        setDescription("");
    }

    @Override
    public void execute(MapleClient c, String[] params) {
        MapleCharacter player = c.getPlayer();
        if (params.length < 1) {
            player.yellowMessage("Syntax: !unban <playername>");
            return;
        }

        try {
            Connection con = DatabaseConnection.getConnection();
            int aid = MapleCharacter.getAccountIdByName(params[0]);

            PreparedStatement p = con.prepareStatement("UPDATE accounts SET banned = -1 WHERE id = " + aid);
            p.executeUpdate();

            p = con.prepareStatement("DELETE FROM ipbans WHERE aid = " + aid);
            p.executeUpdate();

            p = con.prepareStatement("DELETE FROM macbans WHERE aid = " + aid);
            p.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            player.message("Failed to unban " + params[0]);
            return;
        }
        player.message("Unbanned " + params[0]);
    }
}
