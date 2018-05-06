package com.example.maciej.alertwindows;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.NumberPicker;

import com.example.logger.Logger;

/**
 * Dialog window for picking numbers
 */
public class NumberPickerDialog extends DialogFragment {
	
	private static final String TAG = "NumberPicker";
	int offset;
	int value;
	int maxValue;
	String title;
	String message;
	String button1;
	String button2;
	private NumberPicker.OnValueChangeListener valueChangeListener;
	
	public NumberPickerDialog() {
		// Required empty public constructor
	}
	
	
	@Override
	public void setArguments(Bundle args) {
		super.setArguments(args);
		offset = args.getInt("offset", 0);
		value = args.getInt("value", 0);
		maxValue = args.getInt("maxValue",100);
		title = args.getString("title", "default title");
		message = args.getString("message", "default message");
		button1 = args.getString("button1", "OK");
		button2 = args.getString("button2", "Cancel");
	}
	
	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final NumberPicker numberPicker = new NumberPicker(getActivity());
		
		numberPicker.setMinValue(0);
		numberPicker.setValue(value);
		numberPicker.setMaxValue(maxValue);
		numberPicker.setFormatter(new NumberPicker.Formatter() {
			@Override
			public String format(int i) {
				return Integer.toString(i+offset);
			}
		});
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(title);
		builder.setMessage(message);
		
		builder.setPositiveButton(button1, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Logger.d(TAG, "onClick PositiveButton");
				valueChangeListener.onValueChange(numberPicker, numberPicker.getValue()+offset, numberPicker.getValue()+offset);
			}
		});
		
		builder.setNegativeButton(button2, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				Logger.d(TAG, "onClick NegativeButton");
				//valueChangeListener.onValueChange(numberPicker, numberPicker.getValue()+offset, numberPicker.getValue()+offset);
			}
		});
		builder.setView(numberPicker);
		return builder.create();
	}
	
	public NumberPicker.OnValueChangeListener getValueChangeListener() {
		return valueChangeListener;
	}
	
	public void setValueChangeListener(NumberPicker.OnValueChangeListener valueChangeListener) {
		this.valueChangeListener = valueChangeListener;
	}
}
