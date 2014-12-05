package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;

import java.io.DataInputStream;
import java.io.IOException;

public class SiPush extends Instruction
{
	private short s;

	public SiPush(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		s = is.readShort();
		length += 2;
	}

	@Override
	public void execute(Frame frame)
	{
		frame.getStack().push(s);
	}
}
