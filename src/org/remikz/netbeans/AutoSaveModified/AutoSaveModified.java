package org.remikz.netbeans.AutoSaveModified;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.LifecycleManager;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.modules.OnStart;
import org.openide.util.RequestProcessor;

@ActionID(
        category = "File",
        id = "org.remikz.netbeans.AutoSaveModified.AutoSaveModified"
)
@ActionRegistration(
        displayName = "#CTL_AutoSaveModified"
)
@Messages("CTL_AutoSaveModified=Save Automatically")
@OnStart
public final class AutoSaveModified implements ActionListener, Runnable {
    private static final RequestProcessor RP =
            new RequestProcessor(AutoSaveModified.class);
    private final RequestProcessor.Task CLEANER = RP.create(this);
    public int DELAY_MILLIS = 1000;

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void run() {
        LifecycleManager.getDefault().saveAll();
        CLEANER.schedule(DELAY_MILLIS);
    }
}

/*
    AutoSaveModified - Netbeans plugin that automatically saves files.
    Copyright (C) 2016 Remik Ziemlinski

    AutoSaveModified is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    AutoSaveModified is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
