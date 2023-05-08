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
public class it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy extends it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete
    implements RealmObjectProxy, it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface {

    static final class MovieCollectionCompleteColumnInfo extends ColumnInfo {
        long _idColKey;
        long conversation_idColKey;
        long idColKey;
        long movieColKey;
        long speakerColKey;
        long textColKey;

        MovieCollectionCompleteColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("MovieCollectionComplete");
            this._idColKey = addColumnDetails("_id", "_id", objectSchemaInfo);
            this.conversation_idColKey = addColumnDetails("conversation_id", "conversation_id", objectSchemaInfo);
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.movieColKey = addColumnDetails("movie", "movie", objectSchemaInfo);
            this.speakerColKey = addColumnDetails("speaker", "speaker", objectSchemaInfo);
            this.textColKey = addColumnDetails("text", "text", objectSchemaInfo);
        }

        MovieCollectionCompleteColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MovieCollectionCompleteColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MovieCollectionCompleteColumnInfo src = (MovieCollectionCompleteColumnInfo) rawSrc;
            final MovieCollectionCompleteColumnInfo dst = (MovieCollectionCompleteColumnInfo) rawDst;
            dst._idColKey = src._idColKey;
            dst.conversation_idColKey = src.conversation_idColKey;
            dst.idColKey = src.idColKey;
            dst.movieColKey = src.movieColKey;
            dst.speakerColKey = src.speakerColKey;
            dst.textColKey = src.textColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private MovieCollectionCompleteColumnInfo columnInfo;
    private ProxyState<it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete> proxyState;

    it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MovieCollectionCompleteColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public org.bson.types.ObjectId realmGet$_id() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo._idColKey)) {
            return null;
        }
        return (org.bson.types.ObjectId) proxyState.getRow$realm().getObjectId(columnInfo._idColKey);
    }

    @Override
    public void realmSet$_id(org.bson.types.ObjectId value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field '_id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$conversation_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.conversation_idColKey);
    }

    @Override
    public void realmSet$conversation_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.conversation_idColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.conversation_idColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.conversation_idColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.conversation_idColKey, value);
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
    public it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie realmGet$movie() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.movieColKey)) {
            return null;
        }
        return proxyState.getRealm$realm().get(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class, proxyState.getRow$realm().getLink(columnInfo.movieColKey), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$movie(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie value) {
        Realm realm = (Realm) proxyState.getRealm$realm();
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("movie")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie proxyObject = realm.createEmbeddedObject(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class, this, "movie");
                it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.updateEmbeddedObject(realm, value, proxyObject, new HashMap<RealmModel, RealmObjectProxy>(), Collections.EMPTY_SET);
                value = proxyObject;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.movieColKey);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.movieColKey, row.getObjectKey(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.movieColKey);
            return;
        }
        if (RealmObject.isManaged(value)) {
            proxyState.checkValidObject(value);
        }
        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie proxyObject = realm.createEmbeddedObject(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class, this, "movie");
        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.updateEmbeddedObject(realm, value, proxyObject, new HashMap<RealmModel, RealmObjectProxy>(), Collections.EMPTY_SET);
    }

    @Override
    public it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker realmGet$speaker() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.speakerColKey)) {
            return null;
        }
        return proxyState.getRealm$realm().get(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class, proxyState.getRow$realm().getLink(columnInfo.speakerColKey), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$speaker(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker value) {
        Realm realm = (Realm) proxyState.getRealm$realm();
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("speaker")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker proxyObject = realm.createEmbeddedObject(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class, this, "speaker");
                it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.updateEmbeddedObject(realm, value, proxyObject, new HashMap<RealmModel, RealmObjectProxy>(), Collections.EMPTY_SET);
                value = proxyObject;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.speakerColKey);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.speakerColKey, row.getObjectKey(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.speakerColKey);
            return;
        }
        if (RealmObject.isManaged(value)) {
            proxyState.checkValidObject(value);
        }
        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker proxyObject = realm.createEmbeddedObject(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class, this, "speaker");
        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.updateEmbeddedObject(realm, value, proxyObject, new HashMap<RealmModel, RealmObjectProxy>(), Collections.EMPTY_SET);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$text() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.textColKey);
    }

    @Override
    public void realmSet$text(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.textColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.textColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.textColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.textColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "MovieCollectionComplete", false, 6, 0);
        builder.addPersistedProperty(NO_ALIAS, "_id", RealmFieldType.OBJECT_ID, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "conversation_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty(NO_ALIAS, "movie", RealmFieldType.OBJECT, "MovieCollectionCompleteMovie");
        builder.addPersistedLinkProperty(NO_ALIAS, "speaker", RealmFieldType.OBJECT, "MovieCollectionCompleteSpeaker");
        builder.addPersistedProperty(NO_ALIAS, "text", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MovieCollectionCompleteColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MovieCollectionCompleteColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "MovieCollectionComplete";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "MovieCollectionComplete";
    }

    @SuppressWarnings("cast")
    public static it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete obj = null;
        if (update) {
            Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
            MovieCollectionCompleteColumnInfo columnInfo = (MovieCollectionCompleteColumnInfo) realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
            long pkColumnKey = columnInfo._idColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("_id")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstObjectId(pkColumnKey, new org.bson.types.ObjectId((String)json.get("_id")));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class), false, Collections.<String> emptyList());
                    obj = new io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("movie")) {
                excludeFields.add("movie");
            }
            if (json.has("speaker")) {
                excludeFields.add("speaker");
            }
            if (json.has("_id")) {
                if (json.isNull("_id")) {
                    obj = (io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy) realm.createObjectInternal(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy) realm.createObjectInternal(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class, json.get("_id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field '_id'.");
            }
        }

        final it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface objProxy = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) obj;
        if (json.has("conversation_id")) {
            if (json.isNull("conversation_id")) {
                objProxy.realmSet$conversation_id(null);
            } else {
                objProxy.realmSet$conversation_id((String) json.getString("conversation_id"));
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("movie")) {
            if (json.isNull("movie")) {
                objProxy.realmSet$movie(null);
            } else {
                it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.createOrUpdateEmbeddedUsingJsonObject(realm, (RealmModel)objProxy, "movie", json.getJSONObject("movie"), update);
            }
        }
        if (json.has("speaker")) {
            if (json.isNull("speaker")) {
                objProxy.realmSet$speaker(null);
            } else {
                it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.createOrUpdateEmbeddedUsingJsonObject(realm, (RealmModel)objProxy, "speaker", json.getJSONObject("speaker"), update);
            }
        }
        if (json.has("text")) {
            if (json.isNull("text")) {
                objProxy.realmSet$text(null);
            } else {
                objProxy.realmSet$text((String) json.getString("text"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete obj = new it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete();
        final it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface objProxy = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("_id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$_id(null);
                } else {
                    objProxy.realmSet$_id(new org.bson.types.ObjectId(reader.nextString()));
                }
            } else if (name.equals("conversation_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$conversation_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$conversation_id(null);
                }
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("movie")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$movie(null);
                } else {
                    it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie movieObj = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$movie(movieObj);
                }
            } else if (name.equals("speaker")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$speaker(null);
                } else {
                    it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker speakerObj = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$speaker(speakerObj);
                }
            } else if (name.equals("text")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$text((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$text(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field '_id'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class), false, Collections.<String>emptyList());
        io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy obj = new io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete copyOrUpdate(Realm realm, MovieCollectionCompleteColumnInfo columnInfo, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete) cachedRealmObject;
        }

        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
            long pkColumnKey = columnInfo._idColKey;
            org.bson.types.ObjectId value = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$_id();
            long objKey = Table.NO_MATCH;
            if (value == null) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstObjectId(pkColumnKey, value);
            }
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete copy(Realm realm, MovieCollectionCompleteColumnInfo columnInfo, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete) cachedRealmObject;
        }

        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface unmanagedSource = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) newObject;

        Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addObjectId(columnInfo._idColKey, unmanagedSource.realmGet$_id());
        builder.addString(columnInfo.conversation_idColKey, unmanagedSource.realmGet$conversation_id());
        builder.addString(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addString(columnInfo.textColKey, unmanagedSource.realmGet$text());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie movieObj = unmanagedSource.realmGet$movie();
        if (movieObj == null) {
            managedCopy.realmSet$movie(null);
        } else {
            it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie cachemovie = (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie) cache.get(movieObj);
            if (cachemovie != null) {
                throw new IllegalArgumentException("Embedded objects can only have one parent pointing to them. This object was already copied, so another object is pointing to it: cachemovie.toString()");
            } else {
                long objKey = ((RealmObjectProxy) managedCopy).realmGet$proxyState().getRow$realm().createEmbeddedObject(columnInfo.movieColKey, RealmFieldType.OBJECT);
                Row linkedObjectRow = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class).getUncheckedRow(objKey);
                it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie linkedObject = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.newProxyInstance(realm, linkedObjectRow);
                cache.put(movieObj, (RealmObjectProxy) linkedObject);
                it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.updateEmbeddedObject(realm, movieObj, linkedObject, cache, flags);
            }
        }

        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker speakerObj = unmanagedSource.realmGet$speaker();
        if (speakerObj == null) {
            managedCopy.realmSet$speaker(null);
        } else {
            it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker cachespeaker = (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker) cache.get(speakerObj);
            if (cachespeaker != null) {
                throw new IllegalArgumentException("Embedded objects can only have one parent pointing to them. This object was already copied, so another object is pointing to it: cachespeaker.toString()");
            } else {
                long objKey = ((RealmObjectProxy) managedCopy).realmGet$proxyState().getRow$realm().createEmbeddedObject(columnInfo.speakerColKey, RealmFieldType.OBJECT);
                Row linkedObjectRow = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class).getUncheckedRow(objKey);
                it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker linkedObject = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.newProxyInstance(realm, linkedObjectRow);
                cache.put(speakerObj, (RealmObjectProxy) linkedObject);
                it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.updateEmbeddedObject(realm, speakerObj, linkedObject, cache, flags);
            }
        }

        return managedCopy;
    }

    public static long insert(Realm realm, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
        long tableNativePtr = table.getNativePtr();
        MovieCollectionCompleteColumnInfo columnInfo = (MovieCollectionCompleteColumnInfo) realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
        long pkColumnKey = columnInfo._idColKey;
        org.bson.types.ObjectId primaryKeyValue = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$_id();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstObjectId(tableNativePtr, pkColumnKey, primaryKeyValue.toString());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$conversation_id = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$conversation_id();
        if (realmGet$conversation_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.conversation_idColKey, objKey, realmGet$conversation_id, false);
        }
        String realmGet$id = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
        }

        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie movieObj = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$movie();
        if (movieObj != null) {
            Long cachemovie = cache.get(movieObj);
            if (cachemovie != null) {
                throw new IllegalArgumentException("Embedded objects can only have one parent pointing to them. This object was already copied, so another object is pointing to it: " + cachemovie.toString());
            } else {
                cachemovie = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.insert(realm, table, columnInfo.movieColKey, objKey, movieObj, cache);
            }
        }

        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker speakerObj = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$speaker();
        if (speakerObj != null) {
            Long cachespeaker = cache.get(speakerObj);
            if (cachespeaker != null) {
                throw new IllegalArgumentException("Embedded objects can only have one parent pointing to them. This object was already copied, so another object is pointing to it: " + cachespeaker.toString());
            } else {
                cachespeaker = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.insert(realm, table, columnInfo.speakerColKey, objKey, speakerObj, cache);
            }
        }
        String realmGet$text = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$text();
        if (realmGet$text != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.textColKey, objKey, realmGet$text, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
        long tableNativePtr = table.getNativePtr();
        MovieCollectionCompleteColumnInfo columnInfo = (MovieCollectionCompleteColumnInfo) realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
        long pkColumnKey = columnInfo._idColKey;
        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete object = null;
        while (objects.hasNext()) {
            object = (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            org.bson.types.ObjectId primaryKeyValue = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$_id();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstObjectId(tableNativePtr, pkColumnKey, primaryKeyValue.toString());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$conversation_id = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$conversation_id();
            if (realmGet$conversation_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.conversation_idColKey, objKey, realmGet$conversation_id, false);
            }
            String realmGet$id = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
            }

            it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie movieObj = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$movie();
            if (movieObj != null) {
                Long cachemovie = cache.get(movieObj);
                if (cachemovie != null) {
                    throw new IllegalArgumentException("Embedded objects can only have one parent pointing to them. This object was already copied, so another object is pointing to it: " + cachemovie.toString());
                } else {
                    cachemovie = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.insert(realm, table, columnInfo.movieColKey, objKey, movieObj, cache);
                }
            }

            it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker speakerObj = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$speaker();
            if (speakerObj != null) {
                Long cachespeaker = cache.get(speakerObj);
                if (cachespeaker != null) {
                    throw new IllegalArgumentException("Embedded objects can only have one parent pointing to them. This object was already copied, so another object is pointing to it: " + cachespeaker.toString());
                } else {
                    cachespeaker = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.insert(realm, table, columnInfo.speakerColKey, objKey, speakerObj, cache);
                }
            }
            String realmGet$text = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$text();
            if (realmGet$text != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.textColKey, objKey, realmGet$text, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
        long tableNativePtr = table.getNativePtr();
        MovieCollectionCompleteColumnInfo columnInfo = (MovieCollectionCompleteColumnInfo) realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
        long pkColumnKey = columnInfo._idColKey;
        org.bson.types.ObjectId primaryKeyValue = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$_id();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstObjectId(tableNativePtr, pkColumnKey, primaryKeyValue.toString());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$conversation_id = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$conversation_id();
        if (realmGet$conversation_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.conversation_idColKey, objKey, realmGet$conversation_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.conversation_idColKey, objKey, false);
        }
        String realmGet$id = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idColKey, objKey, false);
        }

        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie movieObj = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$movie();
        if (movieObj != null) {
            Long cachemovie = cache.get(movieObj);
            if (cachemovie != null) {
                throw new IllegalArgumentException("Embedded objects can only have one parent pointing to them. This object was already copied, so another object is pointing to it: " + cachemovie.toString());
            } else {
                cachemovie = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.insertOrUpdate(realm, table, columnInfo.movieColKey, objKey, movieObj, cache);
            }
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.movieColKey, objKey);
        }

        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker speakerObj = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$speaker();
        if (speakerObj != null) {
            Long cachespeaker = cache.get(speakerObj);
            if (cachespeaker != null) {
                throw new IllegalArgumentException("Embedded objects can only have one parent pointing to them. This object was already copied, so another object is pointing to it: " + cachespeaker.toString());
            } else {
                cachespeaker = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.insertOrUpdate(realm, table, columnInfo.speakerColKey, objKey, speakerObj, cache);
            }
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.speakerColKey, objKey);
        }
        String realmGet$text = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$text();
        if (realmGet$text != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.textColKey, objKey, realmGet$text, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.textColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
        long tableNativePtr = table.getNativePtr();
        MovieCollectionCompleteColumnInfo columnInfo = (MovieCollectionCompleteColumnInfo) realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
        long pkColumnKey = columnInfo._idColKey;
        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete object = null;
        while (objects.hasNext()) {
            object = (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            org.bson.types.ObjectId primaryKeyValue = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$_id();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstObjectId(tableNativePtr, pkColumnKey, primaryKeyValue.toString());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$conversation_id = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$conversation_id();
            if (realmGet$conversation_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.conversation_idColKey, objKey, realmGet$conversation_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.conversation_idColKey, objKey, false);
            }
            String realmGet$id = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idColKey, objKey, false);
            }

            it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie movieObj = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$movie();
            if (movieObj != null) {
                Long cachemovie = cache.get(movieObj);
                if (cachemovie != null) {
                    throw new IllegalArgumentException("Embedded objects can only have one parent pointing to them. This object was already copied, so another object is pointing to it: " + cachemovie.toString());
                } else {
                    cachemovie = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.insertOrUpdate(realm, table, columnInfo.movieColKey, objKey, movieObj, cache);
                }
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.movieColKey, objKey);
            }

            it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker speakerObj = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$speaker();
            if (speakerObj != null) {
                Long cachespeaker = cache.get(speakerObj);
                if (cachespeaker != null) {
                    throw new IllegalArgumentException("Embedded objects can only have one parent pointing to them. This object was already copied, so another object is pointing to it: " + cachespeaker.toString());
                } else {
                    cachespeaker = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.insertOrUpdate(realm, table, columnInfo.speakerColKey, objKey, speakerObj, cache);
                }
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.speakerColKey, objKey);
            }
            String realmGet$text = ((it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) object).realmGet$text();
            if (realmGet$text != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.textColKey, objKey, realmGet$text, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.textColKey, objKey, false);
            }
        }
    }

    public static it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete createDetachedCopy(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete) cachedObject.object;
            }
            unmanagedObject = (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface unmanagedCopy = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) unmanagedObject;
        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface realmSource = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$_id(realmSource.realmGet$_id());
        unmanagedCopy.realmSet$conversation_id(realmSource.realmGet$conversation_id());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());

        // Deep copy of movie
        unmanagedCopy.realmSet$movie(it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.createDetachedCopy(realmSource.realmGet$movie(), currentDepth + 1, maxDepth, cache));

        // Deep copy of speaker
        unmanagedCopy.realmSet$speaker(it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.createDetachedCopy(realmSource.realmGet$speaker(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$text(realmSource.realmGet$text());

        return unmanagedObject;
    }

    static it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete update(Realm realm, MovieCollectionCompleteColumnInfo columnInfo, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete realmObject, it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface realmObjectTarget = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) realmObject;
        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface realmObjectSource = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxyInterface) newObject;
        Table table = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addObjectId(columnInfo._idColKey, realmObjectSource.realmGet$_id());
        builder.addString(columnInfo.conversation_idColKey, realmObjectSource.realmGet$conversation_id());
        builder.addString(columnInfo.idColKey, realmObjectSource.realmGet$id());

        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie movieObj = realmObjectSource.realmGet$movie();
        if (movieObj == null) {
            builder.addNull(columnInfo.movieColKey);
        } else {
            // Embedded objects are created directly instead of using the builder.
            it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie cachemovie = (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie) cache.get(movieObj);
            if (cachemovie != null) {
                throw new IllegalArgumentException("Embedded objects can only have one parent pointing to them. This object was already copied, so another object is pointing to it: cachemovie.toString()");
            }

            long objKey = ((RealmObjectProxy) realmObject).realmGet$proxyState().getRow$realm().createEmbeddedObject(columnInfo.movieColKey, RealmFieldType.OBJECT);
            Row row = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class).getUncheckedRow(objKey);
            it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie proxyObject = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.newProxyInstance(realm, row);
            cache.put(movieObj, (RealmObjectProxy) proxyObject);
            it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.updateEmbeddedObject(realm, movieObj, proxyObject, cache, flags);
        }

        it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker speakerObj = realmObjectSource.realmGet$speaker();
        if (speakerObj == null) {
            builder.addNull(columnInfo.speakerColKey);
        } else {
            // Embedded objects are created directly instead of using the builder.
            it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker cachespeaker = (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker) cache.get(speakerObj);
            if (cachespeaker != null) {
                throw new IllegalArgumentException("Embedded objects can only have one parent pointing to them. This object was already copied, so another object is pointing to it: cachespeaker.toString()");
            }

            long objKey = ((RealmObjectProxy) realmObject).realmGet$proxyState().getRow$realm().createEmbeddedObject(columnInfo.speakerColKey, RealmFieldType.OBJECT);
            Row row = realm.getTable(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class).getUncheckedRow(objKey);
            it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker proxyObject = it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.newProxyInstance(realm, row);
            cache.put(speakerObj, (RealmObjectProxy) proxyObject);
            it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.updateEmbeddedObject(realm, speakerObj, proxyObject, cache, flags);
        }
        builder.addString(columnInfo.textColKey, realmObjectSource.realmGet$text());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MovieCollectionComplete = proxy[");
        stringBuilder.append("{_id:");
        stringBuilder.append(realmGet$_id() != null ? realmGet$_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{conversation_id:");
        stringBuilder.append(realmGet$conversation_id() != null ? realmGet$conversation_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{movie:");
        stringBuilder.append(realmGet$movie() != null ? "MovieCollectionCompleteMovie" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{speaker:");
        stringBuilder.append(realmGet$speaker() != null ? "MovieCollectionCompleteSpeaker" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{text:");
        stringBuilder.append(realmGet$text() != null ? realmGet$text() : "null");
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
        it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy aMovieCollectionComplete = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aMovieCollectionComplete.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMovieCollectionComplete.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aMovieCollectionComplete.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
