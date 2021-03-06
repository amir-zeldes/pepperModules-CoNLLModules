/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package org.corpus_tools.peppermodules.conll;

import java.util.ArrayList;

public enum ConllDataField {

	ID(1, true), FORM(2, true), LEMMA(3, false, "_"), CPOSTAG(4, false, "_"), POSTAG(5, false, "_"), FEATS(6, false, "_"), HEAD(7, true), DEPREL(8, false, "_"), PHEAD(9, false, "_"), PDEPREL(10, false, "_");

	private final int fieldNum;
	private final boolean mandatory;
	private final String dummyValue;

	ConllDataField(int fieldNum, boolean mandatory) {
		this(fieldNum, mandatory, "");
	}

	ConllDataField(int fieldNum, boolean mandatory, String dummyValue) {
		this.fieldNum = fieldNum;
		this.mandatory = mandatory;
		this.dummyValue = dummyValue;
	}

	public int getFieldNum() {
		return fieldNum;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public String getDummyValue() {
		return dummyValue;
	}

	private static String[] names = null;

	public static String[] getNames() {
		if (names == null) {
			ArrayList<String> namesList = new ArrayList<String>();
			for (ConllDataField field : ConllDataField.values()) {
				namesList.add(field.name());
			}
			names = (String[]) namesList.toArray();
		}
		return names;
	}

	public String getPropertyKey_Name() {
		return getPropertyKey_Name_byFieldNum(fieldNum);
	}

	public static ConllDataField getFieldByNum(int fieldNum) {
		if ((fieldNum > 0) && (fieldNum <= ConllDataField.values().length)) {
			return ConllDataField.values()[fieldNum - 1];
		}
		return null;
	}

	public static String getPropertyKey_Name_byFieldNum(int fieldNum) {
		return "conll.field" + fieldNum + ".name";
	}
}
