/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Sandeep Somavarapu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.ibm.team.rtc.extensions.workitem.copy.value.processors;

import com.ibm.team.rtc.extensions.workitem.copy.internal.EvaluationContext;

public abstract class AbstractReplacementValueProcessor<T> extends AbstractValueProcessor<T> {

	protected String replace(String targetValue, EvaluationContext context) {
		String replacementText= context.configuration.replacementText;
		if (replacementText == null || replacementText.isEmpty()) {
			return targetValue;
		}

		String[] pairs= replacementText.split(",");
		for (String pair : pairs) {
			String key= pair.substring(0, pair.indexOf("=")).trim();
			String value= pair.substring(pair.indexOf("=") + 1).trim();
			targetValue= targetValue.replaceAll("(?i)" + key, value);
		}

		return targetValue;
	}

}
