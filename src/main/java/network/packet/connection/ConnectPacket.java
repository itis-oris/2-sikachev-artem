package network.packet.connection;

import network.packet.Packet;
import network.types.Types;

public class ConnectPacket implements Packet {

    @Override
    public byte[] getData() {
        return new byte[] { Types.CONNECT.getCode() };
    }
}
