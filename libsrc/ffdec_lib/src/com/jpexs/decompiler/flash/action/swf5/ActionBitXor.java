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
package com.jpexs.decompiler.flash.action.swf5;

import com.jpexs.decompiler.flash.BaseLocalData;
import com.jpexs.decompiler.flash.action.Action;
import com.jpexs.decompiler.flash.action.LocalDataArea;
import com.jpexs.decompiler.flash.action.model.operations.BitXorActionItem;
import com.jpexs.decompiler.flash.types.annotations.SWFVersion;
import com.jpexs.decompiler.graph.GraphSourceItem; import com.jpexs.decompiler.graph.GraphTargetItem;
import com.jpexs.decompiler.graph.TranslateStack;
import java.util.HashMap;
import java.util.List;

@SWFVersion(from = 5)
public class ActionBitXor extends Action {

    public ActionBitXor() {
        super(0x62, 0);
    }

    @Override
    public String toString() {
        return "BitXor";
    }

    @Override
    public boolean execute(LocalDataArea lda) {
        if (lda.stack.size() < 2) {
            return false;
        }

        lda.stack.push(BitXorActionItem.getResult(lda.popAsNumber(), lda.popAsNumber()));
        return true;
    }

    @Override
    public void translate(GraphSourceItem lineStartAction, TranslateStack stack, List<GraphTargetItem> output, HashMap<Integer, String> regNames, HashMap<String, GraphTargetItem> variables, HashMap<String, GraphTargetItem> functions, int staticOperation, String path) {
        GraphTargetItem a = stack.pop();
        GraphTargetItem b = stack.pop();
        stack.push(new BitXorActionItem(this, lineStartAction, b, a));
    }

    @Override
    public int getStackPopCount(BaseLocalData localData, TranslateStack stack) {
        return 2;
    }

    @Override
    public int getStackPushCount(BaseLocalData localData, TranslateStack stack) {
        return 1;
    }
}
