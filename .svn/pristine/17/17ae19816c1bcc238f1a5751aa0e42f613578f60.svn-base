package au.edu.parentPortal.fixtures;

import fit.Fixture;
import fit.Parse;

/**
 * Created by hveluchamy on 2/12/2014.
 */
public class SkipFixture extends Fixture {
    public void doTable(Parse tables) {
        // changed to leave the last Parse element attached ... this is the TearDown fixture
        Parse next = tables.more;

        if(next == null){
            return;
        }

        while (next.more != null) {
            next = next.more;
            ignore(next);
        }
        // edit the leader of the final element
        int index = next.leader.indexOf("<div class=\"teardown\"");
        if (index > 0) {
            next.leader = next.leader.substring(index);
        } else {
            next = null;
        }
        tables.more = next;
    }
}
