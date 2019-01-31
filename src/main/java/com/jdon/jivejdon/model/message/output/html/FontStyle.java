package com.jdon.jivejdon.model.message.output.html;

import com.jdon.jivejdon.model.message.MessageVO;

import java.util.function.Function;

/**
 * remove
 * [color=#][/color]
 */
public class FontStyle implements Function<MessageVO, MessageVO> {
	private final static String module = FontStyle.class.getName();

	public MessageVO apply(MessageVO messageVO) {
		return MessageVO.builder().subject(messageVO.getSubject()).body(convertTags
				(messageVO.getBody())).message(messageVO.getForumMessage())
				.build();
	}


	private String convertTags(String input) {
		String parentTagRegx = "\\[[\\/=#! \\w]*color[=#! \\w]*\\](.*?)";
		String parentHtml = "";

		String childTagRex = "";
		String childHtml = "";
		input = ToolsUtil.convertTags(input, parentTagRegx, parentHtml, childTagRex, childHtml);
		return input;
	}
}
