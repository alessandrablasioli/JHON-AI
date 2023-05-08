package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsList;
import io.realm.internal.OsMap;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSet;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.core.NativeRealmAny;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy extends it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker
    implements RealmObjectProxy, it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface {

    static final class MovieCollectionCompleteSpeakerColumnInfo extends ColumnInfo {
        long idColKey;
        long nameColKey;

        MovieCollectionCompleteSpeakerColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("MovieCollectionCompleteSpeaker");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.nameColKey = addColumnDetails("name", "name", objectSchemaInfo);
        }

        MovieCollectionCompleteSpeakerColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MovieCollectionCompleteSpeakerColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MovieCollectionCompleteSpeakerColumnInfo src = (MovieCollectionCompleteSpeakerColumnInfo) rawSrc;
            final MovieCollectionCompleteSpeakerColumnInfo dst = (MovieCollectionCompleteSpeakerColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.nameColKey = src.nameColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private MovieCollectionCompleteSpeakerColumnInfo columnInfo;
    private ProxyState<it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker> proxyState;

    it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MovieCollectionCompleteSpeakerColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idColKey);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.idColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameColKey);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "MovieCollectionCompleteSpeaker", true, 2, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MovieCollectionCompleteSpeakerColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MovieCollectionCompleteSpeakerColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "MovieCollectionCompleteSpeaker";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "MovieCollectionCompleteSpeaker";
    }

    @SuppressWarnings("cast")
    public static it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker createOrUpdateEmbeddedUsingJsonObject(Realm realm, RealmModel parent, String parentProperty, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker obj = realm.createEmbeddedObject(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class, parent, parentProperty);

        final it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface objProxy = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker obj = new it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker();
        final it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface objProxy = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    static it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class), false, Collections.<String>emptyList());
        io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy obj = new io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker copyOrUpdate(Realm realm, MovieCollectionCompleteSpeakerColumnInfo columnInfo, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker copy(Realm realm, MovieCollectionCompleteSpeakerColumnInfo columnInfo, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker) cachedRealmObject;
        }

        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface unmanagedSource = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) newObject;

        Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addString(columnInfo.nameColKey, unmanagedSource.realmGet$name());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, Table parentObjectTable, long parentColumnKey, long parentObjectKey, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker object, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class);
        long tableNativePtr = table.getNativePtr();
        MovieCollectionCompleteSpeakerColumnInfo columnInfo = (MovieCollectionCompleteSpeakerColumnInfo) realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class);
        long objKey = OsObject.createEmbeddedObject(parentObjectTable, parentObjectKey, parentColumnKey);
        cache.put(object, objKey);
        String realmGet$id = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
        }
        String realmGet$name = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Table parentObjectTable, long parentColumnKey, long parentObjectKey, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class);
        long tableNativePtr = table.getNativePtr();
        MovieCollectionCompleteSpeakerColumnInfo columnInfo = (MovieCollectionCompleteSpeakerColumnInfo) realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class);
        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker object = null;
        while (objects.hasNext()) {
            object = (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = OsObject.createEmbeddedObject(parentObjectTable, parentObjectKey, parentColumnKey);
            cache.put(object, objKey);
            String realmGet$id = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
            }
            String realmGet$name = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, Table parentObjectTable, long parentColumnKey, long parentObjectKey, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class);
        long tableNativePtr = table.getNativePtr();
        MovieCollectionCompleteSpeakerColumnInfo columnInfo = (MovieCollectionCompleteSpeakerColumnInfo) realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class);
        long objKey = OsObject.createEmbeddedObject(parentObjectTable, parentObjectKey, parentColumnKey);
        cache.put(object, objKey);
        String realmGet$id = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idColKey, objKey, false);
        }
        String realmGet$name = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Table parentObjectTable, long parentColumnKey, long parentObjectKey, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class);
        long tableNativePtr = table.getNativePtr();
        MovieCollectionCompleteSpeakerColumnInfo columnInfo = (MovieCollectionCompleteSpeakerColumnInfo) realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class);
        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker object = null;
        while (objects.hasNext()) {
            object = (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = OsObject.createEmbeddedObject(parentObjectTable, parentObjectKey, parentColumnKey);
            cache.put(object, objKey);
            String realmGet$id = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idColKey, objKey, false);
            }
            String realmGet$name = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
            }
        }
    }

    public static it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker createDetachedCopy(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker) cachedObject.object;
            }
            unmanagedObject = (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface unmanagedCopy = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) unmanagedObject;
        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface realmSource = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());

        return unmanagedObject;
    }

    static it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker update(Realm realm, MovieCollectionCompleteSpeakerColumnInfo columnInfo, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker realmObject, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface realmObjectTarget = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) realmObject;
        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface realmObjectSource = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxyInterface) newObject;
        Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nameColKey, realmObjectSource.realmGet$name());

        builder.updateExistingEmbeddedObject((RealmObjectProxy) realmObject);
        return realmObject;
    }

    public static void updateEmbeddedObject(Realm realm, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker unmanagedObject, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker managedObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        update(realm, (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.MovieCollectionCompleteSpeakerColumnInfo) realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class), managedObject, unmanagedObject, cache, flags);
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MovieCollectionCompleteSpeaker = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy aMovieCollectionCompleteSpeaker = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aMovieCollectionCompleteSpeaker.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMovieCollectionCompleteSpeaker.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aMovieCollectionCompleteSpeaker.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
