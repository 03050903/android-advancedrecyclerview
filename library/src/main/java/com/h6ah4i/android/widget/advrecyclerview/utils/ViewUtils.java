/*
 *    Copyright (C) 2015 Haruki Hasegawa
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public class ViewUtils {
    static abstract class Impl {
        public abstract void setBackground(View view, Drawable background);
    }

    private static final Impl IMPL;

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            IMPL = new ViewUtilsImplJB();
        } else {
            IMPL = new ViewUtilsImplPreJB();
        }
    }

    private ViewUtils() {
    }

    public static void setBackground(View view, Drawable background) {
        IMPL.setBackground(view, background);
    }
}
