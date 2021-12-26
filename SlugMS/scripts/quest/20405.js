/*
    This file is part of the SlugMS MapleStory Server
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
	Chasing the Knight's Target
	
 */

var status = -1;

function start(mode, type, selection) {
    if (mode == -1) {
        qm.dispose();
    } else {
        if(mode == 0 && type > 0) {
            qm.dispose();
            return;
        }
        
        if (mode == 1)
            status++;
        else
            status--;
        
        if (status == 0) {
            qm.sendNext("There's a note on the wall: 'The source of the curse still goes missing, but a strange device, that I suppose has been used by #rthem#k was found here.'", 3);
        } else if (status == 1) {
            qm.sendNextPrev("'The machine was sent to #rEreve#k for avaliation, I'll now set out to continue my mission. Let the Empress bless me on my journey.'", 3);
        } else if (status == 2) {
            qm.forceCompleteQuest();
            qm.dispose();
        }
    }
}
