/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.bald.uriah.baldphone.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.bald.uriah.baldphone.R;

public class FirstPageAppIcon extends BaldFrameLayoutButton {
    protected final Context context;
    protected final LayoutInflater layoutInflater;
    protected ImageView imageView;
    protected TextView textView;

    public FirstPageAppIcon(Context context) {
        super(context);
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        init(null);
    }

    public FirstPageAppIcon(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        init(attrs);
    }

    public FirstPageAppIcon(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        init(attrs);
    }


    private void init(@Nullable AttributeSet attributeSet) {
        layoutInflater.inflate(R.layout.first_page_app_icon, this, true);
        imageView = findViewById(R.id.iv);
        textView = findViewById(R.id.tv);

        if (attributeSet != null) {
            final TypedArray styleAttributesArray = context.obtainStyledAttributes(attributeSet, R.styleable.FirstPageAppIcon);
            setImageDrawable(styleAttributesArray.getDrawable(R.styleable.FirstPageAppIcon___src));
            setText(styleAttributesArray.getString(R.styleable.FirstPageAppIcon___text));
            styleAttributesArray.recycle();
        }


    }

    public void setText(CharSequence text) {
        textView.setText(text);
    }

    public void setText(@StringRes int resId) {
        textView.setText(resId);
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    public void setImageResource(@DrawableRes int resId) {
        imageView.setImageResource(resId);
    }


    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }


}
