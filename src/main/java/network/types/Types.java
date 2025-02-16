package network.types;

public enum Types {
    CONNECT((byte)0),
    DISCONNECT((byte)1),
    PLAYER_INFO((byte)2),
    BULLET((byte)3),
    GAME_START((byte)4);

    private byte code;

    Types(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }
}