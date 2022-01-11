package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPhoto extends TLAbsPhoto {

    public static final int CONSTRUCTOR_ID = 0xfb197a65;

    protected int flags;

    protected boolean hasStickers;

    protected long id;

    protected long accessHash;

    protected TLBytes fileReference;

    protected int date;

    protected TLVector<TLAbsPhotoSize> sizes;

    protected int dcId;

    private final String _constructor = "photo#fb197a65";

    public TLPhoto() {
    }

    public TLPhoto(boolean hasStickers, long id, long accessHash, TLBytes fileReference, int date,
                   TLVector<TLAbsPhotoSize> sizes, int dcId) {
        this.hasStickers = hasStickers;
        this.id = id;
        this.accessHash = accessHash;
        this.fileReference = fileReference;
        this.date = date;
        this.sizes = sizes;
        this.dcId = dcId;
    }

    private void computeFlags() {
        flags = 0;
        flags = hasStickers ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeInt(date, stream);
        writeTLVector(sizes, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        hasStickers = (flags & 1) != 0;
        id = readLong(stream);
        accessHash = readLong(stream);
        date = readInt(stream);
        sizes = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(fileReference);
        size += SIZE_INT32;
        size += sizes.computeSerializedSize();
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public boolean getHasStickers() {
        return hasStickers;
    }

    public void setHasStickers(boolean hasStickers) {
        this.hasStickers = hasStickers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLVector<TLAbsPhotoSize> getSizes() {
        return sizes;
    }

    public void setSizes(TLVector<TLAbsPhotoSize> sizes) {
        this.sizes = sizes;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLPhoto getAsPhoto() {
        return this;
    }
}
