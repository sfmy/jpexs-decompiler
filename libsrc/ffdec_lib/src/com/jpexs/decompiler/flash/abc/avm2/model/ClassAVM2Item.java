/*
 *  Copyright (C) 2010-2015 JPEXS, All rights reserved.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */
package com.jpexs.decompiler.flash.abc.avm2.model;

import com.jpexs.decompiler.flash.abc.types.Multiname;
import com.jpexs.decompiler.flash.helpers.GraphTextWriter;
import com.jpexs.decompiler.graph.GraphTargetItem;import com.jpexs.decompiler.graph.GraphSourceItem;
import com.jpexs.decompiler.graph.TypeItem;
import com.jpexs.decompiler.graph.model.LocalData;

public class ClassAVM2Item extends AVM2Item {

    public Multiname className;

    public ClassAVM2Item(Multiname className) {
        super(null, null, PRECEDENCE_PRIMARY);
        this.className = className;
    }

    @Override
    public GraphTextWriter appendTo(GraphTextWriter writer, LocalData localData) {
        return writer.append(className.getName(localData.constantsAvm2, localData.fullyQualifiedNames, false));
    }

    @Override
    public GraphTargetItem returnType() {
        return TypeItem.UNBOUNDED;
    }

    @Override
    public boolean hasReturnValue() {
        return false;
    }
}
