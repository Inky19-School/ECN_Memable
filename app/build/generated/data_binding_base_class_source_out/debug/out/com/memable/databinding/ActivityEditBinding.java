// Generated by view binder compiler. Do not edit!
package com.memable.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.memable.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityEditBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button addImage;

  @NonNull
  public final Button button;

  @NonNull
  public final Button button2;

  @NonNull
  public final FloatingActionButton floatingActionButton;

  @NonNull
  public final FloatingActionButton floatingActionButton2;

  @NonNull
  public final Spinner fontFamily;

  @NonNull
  public final Button fontSize;

  @NonNull
  public final ImageView imageWindow;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final LinearLayout linearLayout3;

  @NonNull
  public final Button openFolder;

  @NonNull
  public final Spinner spinner;

  @NonNull
  public final TextView textView6;

  private ActivityEditBinding(@NonNull ConstraintLayout rootView, @NonNull Button addImage,
      @NonNull Button button, @NonNull Button button2,
      @NonNull FloatingActionButton floatingActionButton,
      @NonNull FloatingActionButton floatingActionButton2, @NonNull Spinner fontFamily,
      @NonNull Button fontSize, @NonNull ImageView imageWindow, @NonNull LinearLayout linearLayout,
      @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3,
      @NonNull Button openFolder, @NonNull Spinner spinner, @NonNull TextView textView6) {
    this.rootView = rootView;
    this.addImage = addImage;
    this.button = button;
    this.button2 = button2;
    this.floatingActionButton = floatingActionButton;
    this.floatingActionButton2 = floatingActionButton2;
    this.fontFamily = fontFamily;
    this.fontSize = fontSize;
    this.imageWindow = imageWindow;
    this.linearLayout = linearLayout;
    this.linearLayout2 = linearLayout2;
    this.linearLayout3 = linearLayout3;
    this.openFolder = openFolder;
    this.spinner = spinner;
    this.textView6 = textView6;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEditBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_edit, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEditBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addImage;
      Button addImage = ViewBindings.findChildViewById(rootView, id);
      if (addImage == null) {
        break missingId;
      }

      id = R.id.button;
      Button button = ViewBindings.findChildViewById(rootView, id);
      if (button == null) {
        break missingId;
      }

      id = R.id.button2;
      Button button2 = ViewBindings.findChildViewById(rootView, id);
      if (button2 == null) {
        break missingId;
      }

      id = R.id.floatingActionButton;
      FloatingActionButton floatingActionButton = ViewBindings.findChildViewById(rootView, id);
      if (floatingActionButton == null) {
        break missingId;
      }

      id = R.id.floatingActionButton2;
      FloatingActionButton floatingActionButton2 = ViewBindings.findChildViewById(rootView, id);
      if (floatingActionButton2 == null) {
        break missingId;
      }

      id = R.id.fontFamily;
      Spinner fontFamily = ViewBindings.findChildViewById(rootView, id);
      if (fontFamily == null) {
        break missingId;
      }

      id = R.id.fontSize;
      Button fontSize = ViewBindings.findChildViewById(rootView, id);
      if (fontSize == null) {
        break missingId;
      }

      id = R.id.imageWindow;
      ImageView imageWindow = ViewBindings.findChildViewById(rootView, id);
      if (imageWindow == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.linearLayout3;
      LinearLayout linearLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout3 == null) {
        break missingId;
      }

      id = R.id.openFolder;
      Button openFolder = ViewBindings.findChildViewById(rootView, id);
      if (openFolder == null) {
        break missingId;
      }

      id = R.id.spinner;
      Spinner spinner = ViewBindings.findChildViewById(rootView, id);
      if (spinner == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      return new ActivityEditBinding((ConstraintLayout) rootView, addImage, button, button2,
          floatingActionButton, floatingActionButton2, fontFamily, fontSize, imageWindow,
          linearLayout, linearLayout2, linearLayout3, openFolder, spinner, textView6);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}