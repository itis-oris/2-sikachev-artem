package network.packet.object;

import lombok.Getter;
import network.packet.Packet;
import network.types.Types;

import java.nio.ByteBuffer;

@Getter
public class BulletPacket implements Packet {
    private final int x;
    private final int y;

    public BulletPacket(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public BulletPacket(byte[] data) {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        buffer.get();
        this.x = buffer.getInt();
        this.y = buffer.getInt();
    }

    @Override
    public byte[] getData() {
        ByteBuffer buffer = ByteBuffer.allocate(9);
        buffer.put(Types.BULLET.getCode());
        buffer.putInt(x);
        buffer.putInt(y);
        return buffer.array();
    }
}
